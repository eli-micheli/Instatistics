package instatistics.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import instatistics.service.*;
/*import instatistics.service.InstatisticsSerivceImpl;
import instatistics.service.InstatisticsService;*/

@RestController
public class InstatisticsController {
@Autowired
private InstatisticsServiceImpl instatisticsService;

@RequestMapping(value="/getDataUser/media_type")
public ResponseEntity<Object> getDataUser() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getDataUser("media_type"),HttpStatus.OK);
} // se faccio piu map cambiando il value mi da errore per usare sempre getdata
  // possiamo trovare un modo per ottenere dalla chiamata il tipo di dato
  // così da avere un map solo
@RequestMapping(value="/getAllUser")
public ResponseEntity<Object> getAllUser() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getAllUser(),HttpStatus.OK);
} 
@RequestMapping(value="/getDataPost/media_type")
public ResponseEntity<Object> getDataPost() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getDataPost("media_type"),HttpStatus.OK);
} // se faccio piu map cambiando il value mi da errore per usare sempre getdata
  // possiamo trovare un modo per ottenere dalla chiamata il tipo di dato
  // così da avere un map solo
@RequestMapping(value="/getAllPost")
public ResponseEntity<Object> getAllPost() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getAllPost(),HttpStatus.OK);
} 


}
