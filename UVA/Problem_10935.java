package UVA;
import java.util.*;
public class Problem_10935
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		while(true)
		{
			int n=sc.nextInt();
			if(n==0)
				break;
			if(n==1)
			{
				System.out.println("Discarded cards:");
				System.out.println("Remaining card: 1");
				continue;
			}
			Deque <Integer> deq= new LinkedList<>();
			int tmp=n;
			while(tmp>0)
				deq.addLast(tmp--);
			System.out.print("Discarded cards: ");
			while(deq.size()>1)
			{
				if(deq.size()==2)
					System.out.print(deq.removeLast());
				else
					System.out.print(deq.removeLast()+", ");
				deq.addFirst(deq.removeLast());
			}
			System.out.println();
			System.out.println("Remaining card: "+deq.removeLast());
		}
		sc.close();
	}
}
