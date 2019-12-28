# Config Server
Miroservizio che permette di condividere informazioni di configuraioni su tutti i servizi,
la configurazione attuale è configurata sull'url http://localhost:8888/ms/prod/ dove ms è il nome del servizio chiamate e prod è l'environment di esecuzione.
## Config File
Il file è nella cartella resources/config/ms.yaml oppure è possibile sostituirlo con un file di properties

## Url sample
http://localhost:8888/ms/prod/

## Java
java -jar target/configserver-0.0.1-SNAPSHOT.jar --server.port=8888
