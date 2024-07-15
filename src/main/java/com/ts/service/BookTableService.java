package com.ts.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ts.model.BookTable;
import com.ts.repository.BookTableRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class BookTableService {
	
	@Autowired
    private BookTableRepository bookTableRepository;

    @Autowired
    private JavaMailSender mailSender;
    
    
    //----mail sender api ---//
    
    
    public void sendBookingEmail(String to, String subject, String name, String date_time,String numbe_of_people,String special_request) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        
        helper.setTo(to);
        helper.setSubject(subject);
        String content = "<p>Dear " + name + ",</p>" +
                         "<p>Your table booking is confirmed for " + date_time + ".</p>" +
                         "<p>Number of people: " + numbe_of_people + "</p>" +
                         "<p>Special request: " + special_request + "</p>" +
                         "<p>Thank you!</p>";
        helper.setText(content, true);
        
        mailSender.send(mimeMessage);
    }
   
    public List<BookTable> getAllBookings() {
        return bookTableRepository.findAll();
    }

    public BookTable getBookingById(Long id) {
        return bookTableRepository.findById(id).orElse(null);
    }

    public List<BookTable> getBookingsByName(String name) {
        return bookTableRepository.findByName(name);
    }
   
    public void deleteBooking(Long id) {
        bookTableRepository.deleteById(id);
    }
    
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
	public BookTable saveBooking(String name, String email, String date_time, String numbe_of_people, String special_request) {
		
		 BookTable savedBooking = new BookTable();
		 
		 savedBooking.setName(name);
		 savedBooking.setEmail(email);
		 savedBooking.setNumbe_of_people(numbe_of_people);
		 savedBooking.setDate_time(LocalDateTime.parse(date_time, DATE_TIME_FORMATTER));
	
		 savedBooking.setSpecial_request(special_request);
		 
		 
	    return bookTableRepository.save(savedBooking);
	}
	
	public void deleteAllBookings() {
        bookTableRepository.deleteAll();
    }

}