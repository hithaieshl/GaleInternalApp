package com.galeapp.timer;

import java.util.Calendar;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class BirthdayTask implements ServletContextListener{
	
	public void contextInitialized(ServletContextEvent event) {
        System.out.println("Serverstarted=================>>>>>>>>>");
//        Timer timer = new Timer();
//        Calendar date = Calendar.getInstance();
//        date.set(
//          Calendar.DAY_OF_WEEK,
//          Calendar.SUNDAY
//        );
//        date.set(Calendar.HOUR, 0);
//        date.set(Calendar.MINUTE, 0);
//        date.set(Calendar.SECOND, 0);
//        date.set(Calendar.MILLISECOND, 0);
//        // Schedule to run every Sunday in midnight
//        timer.schedule(new BirthDayTaskTimer(),
//          date.getTime(),
//          1000
//        );
//        
//        Calendar today = Calendar.getInstance();
//        today.set(Calendar.HOUR_OF_DAY, 1);
//        today.set(Calendar.MINUTE, 0);
//        today.set(Calendar.SECOND, 0);
//
//        // every night at 2am you run your task
//       // Timer timer = new Timer();
//        timer.schedule(new BirthDayTaskTimer(), today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // 60*60*24*100 = 8640000ms
// 
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Webapp shutdown.
    }

}

class BirthDayTaskTimer extends TimerTask {

	  public void run() {
	    System.out.println("Generating report");
	    final String username = "enter your username";
      final String password = "enter your password";

   		
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.sendgrid.net");
      props.put("mail.smtp.from", "siva.kumar@galepartners.com");
      props.put("mail.smtp.port", "587");
      
      Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("app27882571@heroku.com", "nsqywkhx1589");
          }
        });

      try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress(props.getProperty("mail.smtp.from")));
          message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse("siva.kumar@galepartners.com"));
          message.setSubject("Happy Birthday");
          message.setText("Hi Happy Birthday");

          Transport.send(message);

          System.out.println("Done");

      } catch (MessagingException e) {
          throw new RuntimeException(e);
      }
	    //TODO generate report
	  }

	}

