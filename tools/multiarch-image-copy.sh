#!/bin/bash
set -e

# This script clone a multi-arch docker image to a private docker registry
# Uncommet these 2 lines to set the image and the private registry
#export myimage="grafana/loki:2.2.1"
#export ocir_prefix="phx.ocir.io/idvjmdrn1r3d/observstack"

if [ -z ${ocir_prefix+x} ] || [ -z ${myimage+x} ]; 
then 
	echo 'Please set the value for myimage and ocir_prefix.'
	echo 'For example:'
	echo ''
    echo '   export myimage=grafana/loki:2.2.1'
    echo '   export ocir_prefix=phx.ocir.io/idvjmdrn1r3d/observstack'
	echo ''
	exit
fi

#Get all platform of an image from source
a=$( docker manifest inspect  ${myimage} | jq '.manifests | .[] | select(.platform.variant != null) | "\(.platform.os)/\(.platform.architecture)/\(.platform.variant)"' | tr '\n' ' ' | tr -d '"' )
b=$( docker manifest inspect  ${myimage}| jq '.manifests | .[] | select(.platform.variant == null) | "\(.platform.os)/\(.platform.architecture)"' | tr '\n' ' ' | tr -d '"' )

#Loop thru variant, pull, retag and push
amend_list=""

for i in $a $b
do

	docker pull ${myimage} --platform ${i}
	tmp_name=$( echo $i | tr '/' '-')
	docker tag  ${myimage} ${ocir_prefix}/${myimage}-${tmp_name}
	docker push ${ocir_prefix}/${myimage}-${tmp_name}
	amend_list="${amend_list} --amend ${ocir_prefix}/${myimage}-${tmp_name}"

done

#Create manifest
docker manifest create ${ocir_prefix}/${myimage} $amend_list
docker manifest push ${ocir_prefix}/${myimage}  ${ocir_prefix}/${myimage}
docker manifest rm ${ocir_prefix}/${myimage}