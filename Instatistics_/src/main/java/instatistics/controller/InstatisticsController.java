package instatistics.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import instatistics.service.*;
/*import instatistics.service.InstatisticsSerivceImpl;
import instatistics.service.InstatisticsService;*/

@RestController
public class InstatisticsController {
@Autowired
private InstatisticsServiceImpl instatisticsService;

//la scrittura in Postman è getDataUser?field=media_type
@RequestMapping(value="/getDataUser")
public ResponseEntity<Object> getDataUser(@RequestParam(name = "field", defaultValue = "media_type") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getDataUser(field),HttpStatus.OK);
} // se faccio piu map cambiando il value mi da errore per usare sempre getdata
  // possiamo trovare un modo per ottenere dalla chiamata il tipo di dato
  // così da avere un map solo
@RequestMapping(value="/getAllUser")
public ResponseEntity<Object> getAllUser() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getAllUser(),HttpStatus.OK);
} 
@RequestMapping(value="/getDataPost")
public ResponseEntity<Object> getDataPost(@RequestParam(name = "field", defaultValue = "media_type") String field) throws ParseException{
	return new ResponseEntity<>(instatisticsService.getDataPost(field),HttpStatus.OK);
} // se faccio piu map cambiando il value mi da errore per usare sempre getdata
  // possiamo trovare un modo per ottenere dalla chiamata il tipo di dato
  // così da avere un map solo
@RequestMapping(value="/getAllPost")
public ResponseEntity<Object> getAllPost() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getAllPost(),HttpStatus.OK);
} 
@RequestMapping(value="/lettura_json")
public ResponseEntity<Object> JsonReading() throws ParseException{
	return new ResponseEntity<>(instatisticsService.JsonReading(),HttpStatus.OK);
} 
/*
@RequestMapping(value="/test")
public ResponseEntity<Object> Test() throws ParseException{
	return new ResponseEntity<>(instatisticsService.Test(),HttpStatus.OK);
} */
@RequestMapping(value="/getMedia")
public ResponseEntity<Object> getMedia() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getMedia(),HttpStatus.OK);
} 

}
