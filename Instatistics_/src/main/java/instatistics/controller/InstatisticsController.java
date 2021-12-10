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

@RequestMapping(value="/media_type")
public ResponseEntity<Object> getMedia() throws ParseException{
	return new ResponseEntity<>(instatisticsService.getMedia("media_type"),HttpStatus.OK);
}
}
