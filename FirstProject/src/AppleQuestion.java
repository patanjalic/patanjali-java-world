public class AppleQuestion {
	public static boolean stopthread;
	public static int counter;
	public static void main(String... args) throws InterruptedException{
		Thread th = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("initiaval of counter "+counter+" "+stopthread);
				while(!stopthread){
					System.out.println("c is " + counter);
					counter++;
				}
			}
			
		});
		th.start();
		Thread.sleep(1000);
		stopthread = true;
		System.out.println("counter is "+counter);
		if(Thread.currentThread().isAlive())
			System.out.println("main is alive");
	}
	
}
