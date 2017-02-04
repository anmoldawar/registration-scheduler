package registrationScheduler.store;

public abstract class ObjectPool{
	static int[] courses=new int[7];
	
	public abstract boolean isAvailable(int num);
	public abstract void giveSeat(int num);
	
    public int getNumActive(int num_course){
		int seats_allocated = courses[num_course];
    	 
    	return seats_allocated;
     }
     
     public int getNumIdle(int num_course){
    	 int seats_left = 60-courses[num_course];
    	 return seats_left;
    	 
     }
}