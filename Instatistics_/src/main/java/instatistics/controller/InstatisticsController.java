package instatistics.controller;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import instatistics.service.*;
/**
 * <b>Classe</b> che descrive le rotte dell'API.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */

@RestController
public class InstatisticsController {
@Autowired
private InstatisticsServiceImpl instatisticsService;

//la scrittura in Postman è getDataUser?field=media_type
/**
 * <b>Rotta</b> che permette di ottenere un particolare tipo di dato
 * di tutti i post dell'user.
 * @param field dato desiderato.Puo' essere media_type,id,caption o datastamp.
 * @return json con i dati desiderati di tutti post.
 */
@RequestMapping(value="/getDataUser")
public ResponseEntity<Object> getDataUser(@RequestParam(name = "field", defaultValue = "media_type") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getDataUser(field),HttpStatus.OK);
} 
/**
 * <b>Rotta</b> che permette di ottenere tutti i dati di tutti i post dell'user. 
 * @return json con tutti i dati di tutti i post dell'user.
 */
@RequestMapping(value="/getAllUser")
public ResponseEntity<Object> getAllUser() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getAllUser(),HttpStatus.OK);
} 
/**
 * <b>Rotta</b> che permette di ottenere un particolare tipo di dato
 * di un particolare post dell'user.
 * @param field dato desiderato. Puo' essere media_type,id,caption o datastamp.
 * @return json con i dati desiderati del post.
 */
@RequestMapping(value="/getDataPost")
public ResponseEntity<Object> getDataPost(@RequestParam(name = "field", defaultValue = "media_type") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getDataPost(field),HttpStatus.OK);
}
/**
 * <b>Rotta</b> che permette di ottenere tutti i dati di tutti di un post dell'user. 
 * @return json con tutti i dati di un post dell'user.
 */
@RequestMapping(value="/getAllPost")
public ResponseEntity<Object> getAllPost() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getAllPost(),HttpStatus.OK);
} 

/*
 * @RequestMapping(value="/lettura_json") public ResponseEntity<Object>
 * JsonReading() throws ParseException{ return new
 * ResponseEntity<>(instatisticsService.JsonReading(),HttpStatus.OK); }
 */ 
/**
 * <b>Rotta</b> che permette di elaborare statistiche sul media_type di tutti i post dell'user.
 * @param metod statistica desiderata. Puo' essere Ranking,Suggestion o NumberOfRepetition.
 * @param field parametro per il metodo "NumberOfRepetion".Indica il tipo di cui si
 * vuole conoscere le ripetizioni. 
 * @return json con le statistiche.
 */
@RequestMapping(value="/getMedia")
public ResponseEntity<Object> getMedia(@RequestParam(name = "metod") String metod, @RequestParam(name = "field", defaultValue = "null") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getMedia(metod,field),HttpStatus.OK);
} 
/**
 * <b>Rotta</b> che permette di elaborare statistiche sulle date di tutti i post dell'user.
 * @param metod statistica desiderata. Puo' essere Ranking o NumberOfRepetition.
 * @param field parametro per il metodo "NumberOfRepetion".Indica l'anno di cui si
 * vuole conoscere le ripetizioni. 
 * @return json con le statistiche.
 */
@RequestMapping(value="/getTimestamp")
public ResponseEntity<Object> getTimestamp(@RequestParam(name = "metod") String metod,@RequestParam(name = "field") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getTimestamp(metod,field),HttpStatus.OK);
}
/**
 * <b>Rotta</b> che permette di elaborare statistiche sulle discalie di tutti i post dell'user.
 * @param metod statistica desiderata. Puo' essere Ranking, Suggestion o NumberOfRepetition.
 * @param field parametro per i metodi. 
 * Per Ranking vanno inseriti i tag o gli hashtag di cui si vuole conoscere la classifica separati da una virgola(es. "#mare,#cielo").
 * Per NumberOfRepetion va inserito l'hashtag o il tag di cui si vuole conoscere il numero di ripetizioni.
 * Per Suggestion va inserito il tema degli hashtag. Questo puo' essere "insieme","cerimonia" o "sport". 
 * @return json con le statistiche.
 */
@RequestMapping(value="/getCaption")
public ResponseEntity<Object> getSuggestionOfCaption(@RequestParam(name = "metod") String metod,@RequestParam(name = "field", defaultValue = "null") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getCaption(metod,field),HttpStatus.OK);
}
/**
 * <b>Rotta</b> che permette di filtare tutti post in base all'anno di pubblicazione.
 * @param field anno per il quale si desidera filtrare i post. 
 * @return json contenente tutti i post del determinato anno.
 */
@RequestMapping(value="/getFilterYear")
public ResponseEntity<Object> getFilterYear(@RequestParam(name = "field", defaultValue = "2021") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getFilterYear(field),HttpStatus.OK);
}
/**
 * <b>Rotta</b> che permette di filtare tutti post in base all'anno di pubblicazione.
 * @param field anno per il quale si desidera filtrare i post. 
 * @return json contenente tutti i post del determinato anno.
 */
@RequestMapping(value="/getFilterPostforDate")
public ResponseEntity<Object> getFilterPostforDate(@RequestParam(name = "field") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getFilterPostforDate(field),HttpStatus.OK);
}
/**
 * <b>Rotta</b> che permette di filtare tutti post in base al tipo di post.
 * @param field tipo per il quale si desidera filtrare i post. 
 * @return json contenente tutti i post del determinato tipo.
 */
@RequestMapping(value="/getFilterMediaType")
public ResponseEntity<Object> getFilterMediaType(@RequestParam(name = "field") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getFilterMediaType(field),HttpStatus.OK);
}





















}
