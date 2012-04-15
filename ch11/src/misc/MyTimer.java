package misc;



import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * 
 * @author fep1
 *
 * Diese Klasse funktioniert wie eine Stopuhr. Mit startTimer l&auml;uft
 * die Zeit mit stopTimer wird die Messung unterbrochen. Die Stopuhr kann
 * mit resetTimer wieder auf 0 zur&uuml;ckgesetzt werden.
 * 
 */
public class MyTimer {
	private long timeValue;
	private long lastTimeValue;
	private long cpuTimeValue;
	private long lastCpuTimeValue;
	private boolean activ = false;
	private ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
	
	public MyTimer() {
		resetTimer();
	}
	/**
	 * Setzt die Stopuhr auf 0 zr&uuml;ck.
	 * 
	 * <pre>
	 *   Precondition:  none
	 *   Postcondition: askTime() = 0
	 *                  askCpuTime() = 0
	 * </pre>
	 *
	 */
	public void resetTimer() {
		timeValue = 0;
		cpuTimeValue = 0;
		activ = false;
	}
	
	/**
	 * Startet die Stopuhr.
	 *
	 *<pre>
	 *   Precondition:  none
	 *   Postcondition: Die Zeit l&auml;uft
	 * </pre>
	 */
	public void startTimer() {
		if (!activ) {
			lastCpuTimeValue = tmxb.getCurrentThreadCpuTime();
			lastTimeValue = System.nanoTime();
			activ = true;
		}
	}
	
	/**
	 *  Unterbricht die Stopuhr.
	 * 
	 *<pre>
	 *   Precondition:  none
	 *   Postcondition: Die Zeit ist angehalten
	 * </pre> 
	 *
	 */
	public void stopTimer() {
		if (activ) {
			cpuTimeValue += tmxb.getCurrentThreadCpuTime() - lastCpuTimeValue;
			timeValue += System.nanoTime() - lastTimeValue;
			activ = false;
		}
	}
	/**
	 * Gibt die gemessene elapsed Time zur&uuml;ck.
	 * 
	 *<pre>
	 *   Precondition:  none
	 *   Postcondition: none
	 * </pre> 
	 * 
	 * @return gemessene elapsed Time in Nanosekunden
	 */
	public long askTime() {
		if (activ) {
			return (System.nanoTime() - lastTimeValue) + timeValue;
		}
		return timeValue;
	}
	/**
	 * Gibt die gemessene cpu Time zur&uuml;ck.
	 * 
	 *<pre>
	 *   Precondition:  none
	 *   Postcondition: none
	 * </pre> 
	 * 
	 * @return gemessene cpu Time in Nanosekunden
	 */	
	public long askCpuTime() {
		if (activ) {
			return (tmxb.getCurrentThreadCpuTime() - lastCpuTimeValue) + cpuTimeValue;
		}
		return cpuTimeValue;
	}
	
	/**
	 * Formatiert einen Wert in Nanosekunden zu einem String in Minuten,
	 * Sekunden und Nanosekunden.
	 * 
	 *<pre>
	 *   Precondition:  none
	 *   Postcondition: none
	 * </pre> 
	 * 
	 * @param timeticks Zeit in Nanosekunden
	 * @return Timestring im Format MM:SS.nanosekunden
	 */
	public String timeString(long timeticks) {
		long nanos = timeticks % 1000000000;
		long sec = (timeticks / 1000000000) % 60;
		long min = (timeticks / 1000000000) / 60;
		
		return String.valueOf(min) + ":" +
		String.valueOf(sec) + "." +
		String.valueOf(nanos);
	}
	
	public String toString() {
		return "Elapsed Time: " + timeString(askTime()) +
		"  CPU Time: " + timeString(askCpuTime());
	}
}
