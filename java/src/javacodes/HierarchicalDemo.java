package javacodes;

 class company {

		
			void company()
			{
				System.out.println("Company : amazon");
			}
		}

		class Developer extends company
		{
			void role()
			{
				System.out.println("Role : Software Developer");
			}
		}
		class Tester extends company
		{
			void role()
			{
				System.out.println("Role : QA Tester");
			}
		}
		public class HierarchicalDemo {

			public static void main(String[] args) {
				Developer dev=new Developer();
				Tester test=new Tester();
				
				dev.company();
				dev.role();
				
				test.company();
				test.role();

			}

		

	}


