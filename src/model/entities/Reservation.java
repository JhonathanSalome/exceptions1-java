package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/*
	 * STATIC(PARA QUE NOT SEJA INSTANCIADO UM NEW SIMPLEDATEFORMAT, PARA CADA
	 * OBJECT RESERVATION QUE APPLICATION TIVER), "APENAS ONE IS NECESSÁRIO"
	 */

	public Reservation() {

	}

	public Reservation(Integer roomNumberBuilder, Date checkInBuilder, Date checkOutBuilder) {
		this.roomNumber = roomNumberBuilder;
		this.checkIn = checkInBuilder;
		this.checkOut = checkOutBuilder;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumberSet) {
		this.roomNumber = roomNumberSet;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// METHOD DURATION IN DAYS
	public long duration() {
		long dura = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dura, TimeUnit.MILLISECONDS);
	}
	/*
	 * LONG(TYPE) DURA(NAME) RECEBE CHECKOUT(METHOD/OPERATION) GETTIME(RETURN
	 * QUANTIDADE IN MILISSEGUNDOS DAQUELA DATA) MENOS CHECKIN
	 * 
	 * RETURN TIMEUNIT(TYPE ENUMERADO COMPLEXO) DAYS(DIAS) CONVERT(CONVERTER)
	 * DURA(VARIÁVEL) TIMEUNIT(TYPE ENUMERADO COMPLEXO) MILLISECONDS(MILESSEGUNDOS)
	 */

	public void updateDuration(Date checkInMethod, Date checkOutMethod) {
		this.checkIn = checkInMethod;
		this.checkOut = checkOutMethod;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation: Room " + roomNumber);
		sb.append(", check-in: " + sdf.format(checkIn));
		sb.append(", check-out: " + sdf.format(checkOut));
		sb.append(", " + duration() + " nights");
		return sb.toString();
	}
}
