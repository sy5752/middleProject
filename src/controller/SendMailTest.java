package controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMailTest  {
	private static final Logger logger = LoggerFactory.getLogger(SendMailTest.class);
	
	public SendMailTest(String email) {
//		System.out.println();
//		System.out.println("메일보내기테스트 진입");
//		System.out.println();
		logger.debug("");
		logger.debug("메일보내기테스트 진입");
		logger.debug("");
		
		
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true"); // gmail은 무조건 true 고정
		p.put("mail.smtp.host", "smtp.gmail.com"); // smtp 서버 주소
		p.put("mail.smtp.auth", "true"); // gmail은 무조건 true 고정
		p.put("mail.smtp.port", "587"); // gmail 포트
		//p.put("mail.smtp.ssl.trust", host);		// 추가

		Authenticator auth = new MyAuthentication();

		// session 생성 및 MimeMessage생성
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);
		
		

		try {
			// 편지보낸시간
			msg.setSentDate(new Date());

			InternetAddress from = new InternetAddress();

			from = new InternetAddress("devlunch4test@gmail.com");

			// 이메일 발신자
			msg.setFrom(from);
//			System.out.println();
//			System.out.println("메일  수신자 " + email);
//			System.out.println();
			
			logger.debug("");
			logger.debug("메일  수신자 {}",email);
			logger.debug("");

			
			// 이메일 수신자
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);

			// 이메일 제목
			msg.setSubject("[호텔 달고나] 회원 가입을 축하합니다.", "UTF-8");

			// 이메일 내용
			msg.setText("[호텔 달고나] 회원가입이 완료 되었습니다.", "UTF-8");

			// 이메일 헤더
			msg.setHeader("content-Type", "text/html");

			// 메일보내기
			javax.mail.Transport.send(msg);

			System.out.println();
			System.out.println("메일  전송 완료 및  종료");
			System.out.println();
		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}
	}

	

}

class MyAuthentication extends Authenticator {

	PasswordAuthentication pa;

	public MyAuthentication() {
		System.out.println();
		System.out.println("메일 계정 정보  진입");
		System.out.println();
		String id = "devlunch4test@gmail.com"; // 구글 ID
		String pw = "ddit1234d"; // 구글 비밀번호

		// ID와 비밀번호를 입력한다.
		pa = new PasswordAuthentication(id, pw);

	}

	// 시스템에서 사용하는 인증정보
	public PasswordAuthentication getPasswordAuthentication() {
		System.out.println();
		System.out.println("메일 계정 인증  진입");
		System.out.println();
		return pa;
	}
}
