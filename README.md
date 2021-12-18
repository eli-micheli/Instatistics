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
3.  Aprire Postman ed eseguire le varie richieste all'indirizzo:*http://localhost8080*


Prima di avviare l'applicazione è importante **ricordare** di inserire il token d'accesso del profilo Instagram del quale si vogliono effetturare le statistiche.
L'applicazione è ora pronta all'utilizzo.
