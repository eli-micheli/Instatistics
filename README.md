# Instatistics
Instatistics è un'applicazione che permette agli utenti di poter effettuare alcune statistiche sul proprio profilo Instagram, di poter filtrare i contenuti al suo interno in base a determinate richieste e a richiesta dell'utente suggerire un hashtag per uno dei temi consigliati dall'app che sono *sport,cerimonia e insieme*. L'applicazione, dunque elabora i dati in formato JSON restituendo a seconda delle richieste dell'utente:
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

# Richieste
Grazie all'utilizzo dell'API REST **GET** si possono effettuare delle richieste all'interno di PostMan a seconda delle rotte che vengono inserite. Le rotte presenti nella nostra applicazione sono le seguenti seguite da una breve descrizione:

|**TIPO**|**ROTTE** |**INDIRIZZO** | **DESCRIZIONE**    |
| :---: | :---: | :---: | :---: | 
|GET|/getDataUser|http://localhost:8080/getDataUser?field= |Verrà restituito l'elenco di tutti i post specificando semplicemente l'Id e il tipo di post di default, ma è possibile accedere anche ad altre caratteristiche dei post scrivendo dopo field una o più delle parole chiave a disposizione (**timestamp**,**caption**,**username**,**media_type**) | 
|GET|/getAllUser|http://localhost:8080/getAllUser|Verrà restituito direttamente l'elenco di tutti i post, con tutti i dati disponibili|
|GET|/getDataPost|http://localhost:8080/getDataPost?field= |Verrà restituito il singolo post con l'Id e il tipo di post di default; se si è interessati ad altri dati riguardanti il post basterà elencare dopo field una delle parole chiave a disposizione(**timestamp**,**caption**,**username**,**media_type**)|
|GET|/getAllPost|http://localhost:8080/getAllPost |Verrà restituito il post con tutti i dati disponibili|
|GET|/getMedia|http://localhost:8080/getMedia?filter=null&metod=NumberOfRepetition&field=IMAGE *media_type*| Inserendo al posto di *media_type* una delle tre parole chiave **IMAGE**,**VIDEO** o **CAROUSEL_ALBUM** verrà restituito il numero di post presenti sul profilo Instagram d'interesse corrispondenti al *media_type* fornito. Se al posto di **null** si inserisce *yearFilter*, *yearOfInterest* (ad esempio *yearFilter*,2021)i post verranno filtrati in funzione dell'anno e verrà restituito il numero di post pubblicati nell'anno indicato corrispondenti al *media_type* fornito |
|GET|/getMedia|http://localhost:8080/getMedia?filter=null&metod=Ranking&field= | Verrà restituito il media_type maggiormente presente sul profilo Instagram in analisi. Quindi analizzando tutti i post tra immagini,album e video restituisce il tipo più frequente. Se al posto di **null** si inserisce *yearFilter*, *yearOfInterest* (ad esempio *yearFilter*,2021)i post verranno filtrati in funzione dell'anno e verrà restituito il tipo maggiormente frequente nell'anno indicato|
|GET|/getMedia|http://localhost:8080/getMedia?filter=null&metod=Suggestion&field= | In funzione del tipo di post maggiormente frequente sul profilo Instagram analizzato e della tipologia dell'ultimo post pubblicato l'applicazione consiglia che tipo di post pubblicare tra: IMAGE,VIDEO o CAROUSEL_ALBUM|
|GET|/getCaption|http://localhost:8080/getCaption?metod=NumberOfRepetition&field= *word*| Inserendo al posto di *word* l'hashtag d'interesse (ad esempio #mare) verrà restituito il numero di volte in cui l'hashtag è stato utilizzato nei post|
|GET|/getCaption|http://localhost:8080/getCaption?metod=Ranking&field= *#parola1,#parola2,#parola3...* |Passando un elenco di hashtag a scelta dell'utente verrà restituito tra quelli scritti quello maggiormente presente sul profilo Instagram e il numero di volte che è stato ripetuto (**IMPORTANTE** separare l'elenco dei vari hashtag attraverso l'utilizzo delle virgole)|
|GET|/getCaption|http://localhost:8080/getCaption?metod=Suggestion&field= *tema* | Scegliendo uno dei temi a disposizione tra *sport*,*insieme* e *cerimonia* l'applicazione consiglierà all'utente un hashtag per il proprio post|
|GET|/getTimestamp|http://localhost:8080/getTimestamp?metod=NumberOfRepetition&field= *year_of_interest* |Inserendo al posto di *year_of_interest* l'anno di interesse verrà restituito il numero di post pubblicati nel'anno indicato|
|GET|/getTimestamp|http://localhost:8080/getTimestamp?metod=Ranking&field= *year1*,*year2*,*year3*... |Inserendo al posto di *year1*,*year2,year3*... un elenco di anni(esempio 2021,2020,2019) verrà restituito l'anno in cui sono stati pubblicati più post e quanti ne sono stati pubblicati(**IMPORTANTE** separare gli anni attraverso l'utilizzo delle virgole)|

# Filtri
|**ROTTE FILTRI**|**INDIRIZZO** | **DESCRIZIONE**    |
| :---: | :---: | :---: | 
|/getFilterYear |http://localhost:8080/getFilterYear?field= *year_of_interest* | Sostituendo *year_of_interest* con l'anno di interesse vengono filtrati tutti i post e saranno restituiti solo quelli pubblicati nell'anno indicato |
|/getFilterPost|http://localhost:8080/getFilterPost?field= *AAAA-MM-GG* |Inserendo una data al posto del campo *AAAA-MM-GG* i post verranno filtrati e se in tale data l'utente ha pubblicato qualche post quest'ultimo verrà restituito, altrimenti verrà restituito che non è stato trovato nulla|
|/getFilterMediaType|http://localhost:8080/getFilterMediaType?field= *media_type* |Sostituendo *media_type* con una delle parole chiavi IMAGE,VIDEO o CAROUSEL_ALBUM i post vengono filtrati e verranno restituiti solo quelli corrispondenti al *media_type* indicato|

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




