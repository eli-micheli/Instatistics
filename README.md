# Instatistics
Instatistics è un'applicazione che permette agli utenti di poter effettuare alcune statistiche sul proprio profilo Instagram, di poter filtrare i contenuti al suo interno in base a determinate richieste e a richiesta dell'utente suggerire un hashtag per uno dei temi consigliati dall'app che sono *sport,cerimonia e insieme*. L'applicazione, dunque elabora i dati in formato JSON restituendo a seconda delle richieste dell'utente:
* tutti i post presenti su un profilo
* l'elenco di tutti i post con solo alcune caratteristiche e non tutti i dati che li contraddistinguono passando le corrette parole chiave nel field
* i dati relativi ad un singolo post
* restituire statistiche su dati che siano stati filtrati a richiesta dell'utente
* restituire un hashtag a seconda di quale sia il tema richiesto



L'applicazione è stata sviluppata grazie all'utilizzo di SpringBoot, un framework che consente di lanciare l'intera applicazione web tramite protocollo http.

# Come avviare Instatistics
Per avviare Instatistics prima di tutto è necessario installare Eclipse, un ambiente di sviluppo multilinguaggio, creare un account su GitHub, che è invece un servizio di hosting per progetti software e installare il programma Postman, un' applicazione che permette di testare le API. Fatto ciò bisognerà eseguire i seguenti passaggi:
1.  Clonare la repository del progetto GitHub
2.  Importare la cartella relativa al programma su Eclipse e avviare il programma come applicazione SpringBoot(SpringBoot App)
3.  **Ricordare** di inserire il token d'accesso del profilo Instagram del quale si vogliono effetturare le statistiche.
4.  Aprire Postman ed eseguire le varie richieste all'indirizzo:*http://localhost8080*

L'applicazione è ora pronta all'utilizzo.

# Richieste
Grazie all'utilizzo dell'API REST **GET** si possono effettuare delle richieste all'interno di PostMan a seconda delle rotte che vengono inserite. Le rotte presenti nella nostra applicazione sono le seguenti seguite da una breve descrizione:

|**TIPO**|**ROTTE**  | **DESCRIZIONE**    |
| :---: | :---: | :---: | 
|GET|/getDataUser|Scrivendo semplicemente la rotta PostMan restituirà l'elenco di tutti i post specificando semplicemente l'Id e il tipo di post; inserendo invece come Query Params  **field** è possibile avere anche altre caratteristiche passando parole chiave come **timestamp**,**caption**,**username**| 
|GET|/getAllUser|Scrivendo la rotta PostMan restituirà direttamente l'elenco di tutti i post, con tutte le caratteristiche|
|GET|/getDataPost|Scrivendo la rotta PostMan restituisce il singolo post con l'Id e il tipo di post;inserendo come Query Params **field** è possibile ottenere anche altri dati passando le corrette parole chiave(**timestamp**,**caption**,**username**,**media_type**)|
|GET|/getAllPost|Scrivendo la rotta PostMan restituisce il post con tutti i campi d'interesse|
|GET|/getMedia|Per la seguente rotta è necessario introdurre due Query Params aventi come key **metod** e **field**. I valori che possono essere assegnati a *metod* sono: **NumberOfRepetition**,**Ranking** e **Suggestion**. I valori che possono essere assegnati a *field* sono:**IMAGE**, **VIDEO** e **CAROUSEL_ALBUM**.Esempio di richiesta:http://localhost:8080/getMedia?metod=NumberOfRepetition&field=IMAGE. Per accedere ai risultati di *Ranking* e *Suggestion* non è necessario passare alcun valore per field, ma la **key** field va comunque inserita nella richiesta|
|GET|/getTimestamp|Per la seguente rotta è necessario introdurre due Query Params aventi come key **metod** e **field**. I valori che possono essere assegnati a *metod* sono: **NumberOfRepetition** e **Ranking**. A **field** andranno passati come parametri gli anni d'interesse.Esempio di richieste:http://localhost:8080/getTimestamp?metod=NumberOfRepetition&field=2021,http://localhost:8080/getTimestamp?metod=Ranking&field=2021,2020|

