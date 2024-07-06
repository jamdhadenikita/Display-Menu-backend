package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ts.model.BookTable;
import com.ts.repository.BookTableRepository;

@Service
public class BookTableService {
	
	@Autowired
    private BookTableRepository bookTableRepository;

    @Autowired
    private JavaMailSender mailSender;

    public List<BookTable> getAllBookings() {
        return bookTableRepository.findAll();
    }

    public BookTable getBookingById(Long id) {
        return bookTableRepository.findById(id).orElse(null);
    }

    public List<BookTable> getBookingsByName(String name) {
        return bookTableRepository.findByName(name);
    }

    public BookTable saveBooking(BookTable bookTable) {
        BookTable savedBooking = bookTableRepository.save(bookTable);
        sendBookingEmail(savedBooking);
        return savedBooking;
    }

    public void deleteBooking(Long id) {
        bookTableRepository.deleteById(id);
    }

    private void sendBookingEmail(BookTable bookTable) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(bookTable.getEmail());
        message.setSubject("Table Booking Confirmation");
        message.setText("Dear " + bookTable.getName() + ",\n\nYour table booking is confirmed for " + bookTable.getDate_time() +
                        ".\n\nNumber of people: " + bookTable.getNumbe_of_people() +
                        "\nSpecial request: " + bookTable.getSpecial_request() + "\n\nThank you!");

        mailSender.send(message);
    }
}