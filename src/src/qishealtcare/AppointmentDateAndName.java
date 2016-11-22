package qishealtcare;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class AppointmentDateAndName {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int a[] = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = s.nextInt();
		}
		s.close();
	}

	static String[] reformatPatientAppointment(String[] patientName, String[] appointmentDate) {
		ArrayList<String> dates =  new ArrayList<>();
		HashMap<String, String> app = new HashMap<>();
		for (int i = 0; i < appointmentDate.length; i++) {
			app.put(appointmentDate[i],patientName[i]);
		}
		for (int i = 0; i < appointmentDate.length; i++) {
			dates.add(appointmentDate[i]);
		}
		Collections.sort(dates, new Comparator<String>() {
			DateFormat f = new SimpleDateFormat("ddMMyyyy hh:mm");
			@Override
			public int compare(String o1, String o2) {
				try {
					return f.parse(o1).compareTo(f.parse(o2));
				} catch (Exception e) {
					throw new IllegalArgumentException(e);
				}
			}
		});
		int i=0;
		for (String date : dates) {
			appointmentDate[i]=app.get(date)+" - "+date;
			i++;
		}
		
		return appointmentDate;


	}


}
