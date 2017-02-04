package registrationScheduler.store;

/**
 * @author anmol
 */

public class Scheduling extends ObjectPool{

	int pref_score=0;
	int num_courses=0;
	String line;

	/**
	 * 
	 * @param s - Line from input file having name and priorities of students
	 * @return allocated course list fro that student
	 */
	
	public synchronized String scheduleCourses(String s){
		pref_score=0;
		num_courses=0;
		line = s;
		String options[] = line.split(" ");
		String name = options[0];
		int index_first=0;int index_second=0;int index_third=0;
		int index_fourth=0;int index_fifth=0;int index_sixth=0;int index_seventh=0;
		//ArrayList<String> input = new ArrayList<String>();
		
		for(int j =0;j<options.length;j++){
			if(options[j].equals("1")){
				index_first = j;
			}
			if(options[j].equals("2")){
				index_second=j;
			}
			if(options[j].equals("3")){
				index_third=j;
			}
			if(options[j].equals("4")){
				index_fourth=j;
			}
			if(options[j].equals("5")){
				index_fifth=j;
			}
			if(options[j].equals("6")){
				index_sixth=j;
			}
			if(options[j].equals("7")){
				index_seventh=j;
			}	
		}

		String s6,s7;
		String s1 = whichCourse(index_first,1);

		if(!(s1.equals(" "))){
			num_courses++;
		}
		String s2 = whichCourse(index_second,2);
		if(!(s2.equals(" "))){
			num_courses++;
		}
		String s3 = whichCourse(index_third,3);
		if(!(s3.equals(" "))){
			num_courses++;
		}
		String s4 = whichCourse(index_fourth,4);
		if(!(s4.equals(" "))){
			num_courses++;
		}
		String s5 = whichCourse(index_fifth,5);
		if(!(s5.equals(" "))){
			num_courses++;
		}
		
		String courses_list = s1+s2+s3+s4+s5;
		
		if(courses_list.contains(" ")){
			s6 = whichCourse(index_sixth,6);
			courses_list = courses_list.replace(" ", "");
			
			if((!(s6.equals(" ")))){
				courses_list = courses_list+s6;
				num_courses++;
			}
		}
		
		if(num_courses<5){
			s7 = whichCourse(index_seventh,7);
			courses_list = courses_list.replace(" ", "");
			if(!(s7.equals(" "))){
				courses_list = courses_list + s7;
				num_courses++;
			}
		}
		
		if(courses_list.contains(" ")){
			//borrow objects 
		}
		
		return name+" "+courses_list+" "+pref_score;
	}
	
	/**Method to check which is the course corresponding to the choice index
	 * 
	 * @param index- index of choices 
	 * @param p- preference score to be added
	 * @return- string of appropriate course
	 */
	
	public synchronized String whichCourse(int index,int p){
		int ret_value;
		String s = " ";
		if(index==1){
			ret_value = allocateCourse('A');
			if(ret_value==1){
				s = "A";
				pref_score=pref_score+p;
			}
		}
		else if(index==2){
			ret_value = allocateCourse('B');
			if(ret_value==1){
				s = "B";
				pref_score=pref_score+p;
			}
		}
		else if(index==3){
			ret_value = allocateCourse('C');
			if(ret_value==1){
				s = "C";
				pref_score=pref_score+p;
			}
		}
		else if(index==4){
			ret_value = allocateCourse('D');
			if(ret_value==1){
				s = "D";
				pref_score=pref_score+p;
			}
		}
		else if(index==5){
			ret_value = allocateCourse('E');
			if(ret_value==1){
				s = "E";
				pref_score=pref_score+p;
			}
		}
		else if(index==6){
			ret_value = allocateCourse('F');
			if(ret_value==1){
				s = "F";
				pref_score=pref_score+p;
			}
		}
		else if(index==7){
			ret_value = allocateCourse('G');
			if(ret_value==1){
				s = "G";
				pref_score=pref_score+p;
			}
		}
		return s;
	}
	
	/**Method to allocate course
	 * 
	 * @param c- course to be allocated
	 * @return - integer signifying whether the course was allocated successfully or not
	 */
	
	public synchronized int allocateCourse(char c){
		int allocated=0;
		
		if(c=='A'){
			if(isAvailable(0)){
					giveSeat(0);
					allocated = 1;
			}
			
		}
		if(c=='B'){
			if(isAvailable(1)){
					giveSeat(1);
					allocated = 1;
			}
		}
		if(c=='C'){
			if(isAvailable(2)){
					giveSeat(2);
					allocated=1;		
			}
			
		}
		if(c=='D'){
				if(isAvailable(3)){
					giveSeat(3);
					allocated=1;
				}	
			}		
		if(c=='E'){
			if(isAvailable(4)){
				giveSeat(4);
				allocated=1;
			}	
		}		
	
		if(c=='F'){
			if(isAvailable(5)){
				giveSeat(5);
				allocated=1;
			}
		}		
	
		if(c=='G'){
			if(isAvailable(6)){
				giveSeat(6);
				allocated=1;
			}	
		}	
			return allocated;
		}	

	/**Method to check whether there is availability in course or not
	 * @param num - course number 
	 * returns true or false
	 */
	
	public synchronized boolean isAvailable(int num) {
		if(getNumActive(num)<60){
			return true;
	     }
	     else{
	    	 return false;
	     }
	}

	/**Method to allocate course to a student
	 * 
	 * @param num - 
	 */
	public synchronized void giveSeat(int num) {
		courses[num]++;	
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}