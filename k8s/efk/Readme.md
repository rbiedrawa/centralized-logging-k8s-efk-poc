# ElasticSearch, Kibana and Fluentd (EFK stack)



#### Installation

```
kubectl create -f namespace.yml

# Create 3 node elasticsearch cluster
kubectl create -f ./elasticsearch/

# create kibana ui - this may take some time for rollout to complete
kubectl create -f ./kibana/

kubectl create configmap fluentd-conf --from-file=./fluentd/kubernetes.conf --namespace=efk-logging
kubectl create -f ./fluentd/fluentd.rbac.yml
kubectl create -f ./fluentd/fluentd.daemon.set.yml
```

#### Port Forward commands
```
# Kibana
kubectl port-forward -n efk-logging svc/kibana 8081:5601
```

#### Uninstall

```
kubectl delete all --all -n efk-logging
kubectl delete namespace efk-logging
```


#### Setup

Add Index Pattern

![Ekf-stack](./../../../../docs/img/Elk-setup.png)

Use Kibana Filters: