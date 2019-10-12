.\oc create secret generic diego-consume-secret --from-file=cacerts
.\oc export is,dc,bc,svc,route --selector app=diego-consume-openshift -o yaml --as-template=diego-consume-openshift  >> diego-consume-openshift.yml
.\oc delete all --selector app= diego-consume-openshift
.\oc new-app -f .\diego-consume-openshift.yml