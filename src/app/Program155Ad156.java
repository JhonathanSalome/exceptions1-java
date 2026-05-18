package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program155Ad156 {

	void main(String[] args) throws ParseException {

		/*
		 * AULA 155, CRIANDO EXCEÇÕES PERSONALIZADAS AND
		 * 
		 * AULA 156, PRIMEIRA SOLUÇÃO - MUITO RUIM
		 */

		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		IO.print("Room number: "); int number = teclado.nextInt();
		IO.print("Check-in data (dd/MM/yyyy): "); Date checkIn = sdf.parse(teclado.next());
		IO.print("Check-out data (dd/MM/yyyy): "); Date checkOut = sdf.parse(teclado.next());

		if (!checkOut.after(checkIn)) {
			/*
			 * AFTER(TESTA UMA DATA DEPOIS DA OUTRA)
			 */
			IO.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation res = new Reservation(number, checkIn, checkOut); IO.println(res.toString());

			IO.println("\nEnter data to update the reservation: ");
			IO.print("Check-in (dd/MM/yyyy): "); checkIn = sdf.parse(teclado.next());
			IO.print("Check-out (dd/MM/yyyy): "); checkOut = sdf.parse(teclado.next());

			Date now = new Date();
			/*
			 * DATE(CLASS) NOW(NAME) RECEBE NEW(INSTANCIAR) DATE(CLASS)
			 */
			if (checkIn.before(now) || checkOut.before(now)) {
				/*
				 * SE A CHECK-IN(DATA DO CHECK-IN) FOR BEFORE(ANTERIOR) NOW(DATA ATUAL) ||(OR)
				 */
				
				IO.println("Error in reservation: Check-out date must be after check-in date");
			} else if (!checkOut.after(checkIn)) {
				/*
				 * SE A DATA DE CHECK-OUT NOT(!), AFTER(TESTA UMA DATA DEPOIS DA OUTRA), FOR
				 * POSTERIOR A DATA DE CHECK-IN, NOT PODE ACEITAR
				 */

				IO.println("Error in reservation: Reservation dates for update must be future dates");
			} else {
				res.updateDuration(checkIn, checkOut);
				/* METHOD(OPERATION), RESPONSÁVEL POR ATUALIZAR AS DATAS */

				IO.println(res.toString());
			}
		}

		teclado.close();
	}

}
