# Instatistics
Instatistics è un'applicazione che permette agli utenti di poter effettuare alcune statistiche sul proprio profilo Instagram, di poter filtrare i contenuti al suo interno in base a determinate richieste e suggerire un hashtag per uno dei temi consigliati dall'app che sono *sport,cerimonia e insieme*. L'applicazione, dunque elabora i dati in formato JSON restituendo a seconda delle richieste dell'utente:
* tutti i post presenti su un profilo
* l'elenco di tutti i post con solo alcune caratteristiche e non tutti i dati che li contraddistinguono passando le corrette parole chiave nel field
* i dati relativi ad un singolo post
* restituire statistiche su dati che siano stati filtrati a richiesta dell'utente, nell'applicazione questa possibilità è stata implementata per statistiche sul tipo di post, ma può essere facilmente estesa anche alle altre rotte
* restituire un hashtag a seconda di quale sia il tema richiesto



L'applicazione è stata sviluppata grazie all'utilizzo di SpringBoot, un framework che consente di lanciare l'intera applicazione web tramite protocollo http.

# Come avviare Instatistics
Per avviare Instatistics prima di tutto è necessario installare Eclipse, un ambiente di sviluppo multilinguaggio, creare un account su GitHub, che è invece un servizio di hosting per progetti software e installare il programma Postman, un' applicazione che permette di testare le API. Fatto ciò bisognerà eseguire i seguenti passaggi:
1.  Clonare la repository del progetto GitHub
2.  Importare la cartella relativa al programma su Eclipse e avviare il programma come applicazione SpringBoot(SpringBoot App)
3.  **Ricordare** di inserire il token d'accesso del profilo Instagram del quale si vogliono effetturare le statistiche.
4.  Aprire Postman ed eseguire le varie richieste all'indirizzo:*http://localhost8080*

L'applicazione è ora pronta all'utilizzo.

# Dati disponibili
Breve descrizione dei dati disponibili sui post:
|  **DATO**  | **DESCRIZIONE**    |   
| :---: | :---: |
| **timestamp** | La data di pubblicazione del contenuto multimediale in formato ISO 8601 | 
| **media_type** | Il tipo di contenuto multimediale. Può essere IMAGE, VIDEO o CAROUSEL_ALBUM|
| **caption** | Il testo della didascalia del contenuto multimediale|
| **username** |Il nome utente del creatore del contenuto multimediale |

# Rotte
Grazie all'utilizzo dell'API REST **GET** si possono effettuare delle richieste all'interno di PostMan a seconda delle rotte che vengono inserite. Le rotte presenti nella nostra applicazione sono le seguenti seguite da una breve descrizione:
|**TIPO**|**ROTTE**|**INDIRIZZO**| **DESCRIZIONE**|
| :---: | :---: | :---: | :---: | 
|GET|/getAllUser|http://localhost:8080/getAllUser|Verrà restituito l'elenco di tutti i post, con tutti i dati disponibili|
|GET|/getMedia|http://localhost:8080/getMedia?filter= *filtro* ?metod= *metodo* &field= *campo* | Restituisce statistiche sul tipo di media. Tramite la key **filter** si possono filtrare i post dell'utente su cui fare le statistiche. Tramite la key **metod** si definisce la statistica da ottenere. Tramite la key **field** si definisce il parametro per la statistica.|
|GET|/getCaption|http://localhost:8080/getCaption?metod= *metodo* &field= *campo* | Restituisce statistiche sulla didascalia dei post. Tramite la key **metod** si definisce la statistica da ottenere. Tramite la key **field** si definisce il parametro per la statistica.|
|GET|/getTimestamp|http://localhost:8080/getTimestamp?metod= *metodo* &field= *campo* | Restituisce statistiche sulla data di pubblicazione dei post. Tramite la key **metod** si definisce la statistica da ottenere. Tramite la key **field** si definisce il parametro per la statistica.|
|GET|/getFilterYear |http://localhost:8080/getFilterYear?field= *year_of_interest* | Sostituendo *year_of_interest* con l'anno di interesse vengono filtrati tutti i post e saranno restituiti solo quelli pubblicati nell'anno indicato |
|GET|/getFilterPost|http://localhost:8080/getFilterPost?field= *AAAA-MM-GG* |Inserendo una data al posto del campo *AAAA-MM-GG* i post verranno filtrati e se in tale data l'utente ha pubblicato qualche post quest'ultimo verrà restituito, altrimenti verrà restituito che non è stato trovato nulla|
|GET|/getFilterMediaType|http://localhost:8080/getFilterMediaType?field= *media_type* |Sostituendo *media_type* con una delle parole chiavi IMAGE,VIDEO o CAROUSEL_ALBUM i post vengono filtrati e verranno restituiti solo quelli corrispondenti al *media_type* indicato|

# Richieste
**GET MEDIA**

* **Metodo:Ranking**
Verrà restituito il media_type maggiormente presente sul profilo Instagram in analisi. Quindi analizzando tutti i post tra IMAGE, CAROUSEL_ALBUM e VIDEO restituisce il tipo più frequente. Se nella key **filter** si inserisce *yearFilter*, *yearOfInterest* (ad esempio *yearFilter*,2021)i post verranno filtrati in funzione dell'anno e verrà restituito il tipo maggiormente frequente nell'anno indicato.

![MicrosoftTeams-image (2)](https://user-images.githubusercontent.com/94125029/147115133-fb68e33d-e41b-43f1-8c7e-fd8731b71579.png)
* **Metodo:NumberOfRepetition**
Inserendo al posto di *media_type* una delle tre parole chiave **IMAGE**,**VIDEO** o **CAROUSEL_ALBUM** verrà restituito il numero di post presenti sul profilo Instagram d'interesse corrispondenti al *media_type* fornito. Se si inserisce *yearFilter*, *yearOfInterest* (ad esempio *yearFilter*,2021)i post verranno filtrati in funzione dell'anno e verrà restituito il numero di post pubblicati nell'anno indicato corrispondenti al *media_type* fornito.

![MicrosoftTeams-image (13)](https://user-images.githubusercontent.com/94125029/147117809-75dd93f8-2286-4bb4-a6b6-92f908258b93.png)

* **Metodo:Suggestion**
 In funzione del tipo di post maggiormente frequente sul profilo Instagram analizzato e della tipologia dell'ultimo post pubblicato l'applicazione consiglia che tipo di post pubblicare tra: IMAGE,VIDEO o CAROUSEL_ALBUM.
 ![MicrosoftTeams-image (1)](https://user-images.githubusercontent.com/94125029/147115805-b4eb6f8b-2216-4360-9df5-e4d5146952b4.png)
 
 **GET CAPTION**
 * **Metodo:Ranking**
Passando un elenco di hashtag a scelta dell'utente verrà restituito tra quelli scritti quello maggiormente presente sul profilo Instagram e il numero di volte che è stato ripetuto (**IMPORTANTE** separare l'elenco dei vari hashtag attraverso l'utilizzo delle virgole)

![Cattsura](https://user-images.githubusercontent.com/94125029/147117013-6b6eb1ac-2885-4aec-8389-3df3684c1ae5.PNG)

* **Metodo:NumberOfRepetition**
Inserendo l'hashtag d'interesse (ad esempio #mare) verrà restituito il numero di volte in cui l'hashtag è stato utilizzato nei post

![MicrosoftTeams-image (5)](https://user-images.githubusercontent.com/94125029/147116782-e7fb0394-7ddb-478a-9d49-3da488578859.png)

* **Metodo:Suggestion**
  Scegliendo uno dei temi a disposizione tra *sport*,*insieme* e *cerimonia* l'applicazione consiglierà all'utente un hashtag per il proprio post
 
 ![MicrosoftTeams-image (10)](https://user-images.githubusercontent.com/94125029/147116437-29d0679b-15df-4d95-9e81-c637d69910d2.png)
 
 **GET TIMESTAMP**
 * **Metodo:Ranking**
 Inserendo al posto di un elenco di anni(esempio 2021,2020,2019) verrà restituito l'anno in cui sono stati pubblicati più post e quanti ne sono stati pubblicati(**IMPORTANTE** separare gli anni attraverso l'utilizzo delle virgole)
 
 ![MicrosoftTeams-image (11)](https://user-images.githubusercontent.com/94125029/147117340-920e61e3-fc44-4075-9c4d-c95fead3b48c.png)
 
 * **Metodo:NumberOfRepetition**
 Inserendo l'anno di interesse verrà restituito il numero di post pubblicati nel'anno indicato
 
 ![MicrosoftTeams-image (12)](https://user-images.githubusercontent.com/94125029/147117600-66c812e9-a1dd-4edd-ab6b-13a3c9c22e30.png)








 














# Statistiche
L'applicazione può dunque effettuare alcune statistiche facendo riferimento alla caption, alla data di pubblicazione e al tipo dei post. In particolare per:

**MEDIA TYPE:**
* indicare quanti post di un certo tipo sono presenti su un profilo(IMAGE, VIDEO o CAROUSEL_ALBUM)
* indicare quale tra tutti i tipi è il più utilizzato dall'utente

**CAPTION**
* fornendo un hashtag a scelta l'applicazione è in grado di indicare quante volte è stato utilizzato nei post
* fornendo un elenco di hashtag l'applicazione è in grado di indicare quale sia stato utilizzato più volte e quante volte 

**TIMESTAMP**
* fornendo un anno di riferimento l'applicazione è in grado di restituire quanti post sono stati pubblicati nell'anno indicato
* fornendo un elenco di anni l'applicazione indica in quale anno siano stati pubblicati più post e quanti ne sono stati effettivamente pubblicati

# Autori
* Elisa Micheli
* Sara Mattioli




