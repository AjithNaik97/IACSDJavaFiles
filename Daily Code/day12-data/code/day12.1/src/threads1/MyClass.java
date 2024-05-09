package threads1;

public class MyClass extends Thread {
	public MyClass(String name) {
		super(name);
	}

	// mandatory to override run()
	/*
	 * Rule - method overriding n exception handling Overriding form of the
	 * method(sub class version) CAN NOT throw any NEW or BROADER CHECKED exception
	 */
	@Override
	public void run() /* throws InterruptedException */ {
		System.out.println(getName() + " strted");
		try {
			// B.L -- for loop (10)
			for (int i = 0; i < 10; i++) {
				System.out.println(getName() + " exec count " + i);
				if(Thread.currentThread().getName().equals("three"))
				{
					System.out.println("Enter data:");
					int data =System.in.read();
					System.out.println("Your entered:"+data);
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println(getName() + " got exc " + e);
		}
		System.out.println(getName() + " over");
	}
}
