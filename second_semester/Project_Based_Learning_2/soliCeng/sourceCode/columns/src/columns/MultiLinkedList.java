package columns;


import static columns.Columns.console;

public class MultiLinkedList {
	private ColumnNode head;
	
	//create a column
	public void addColumn(String dataToAdd) {
		if (head == null) {
			ColumnNode newNode = new ColumnNode(dataToAdd);
			head = newNode;
		}
		else {
			ColumnNode temp = head;
			while (temp.getDown() != null) {
				temp = temp.getDown();
			}
			
			ColumnNode newNode = new ColumnNode(dataToAdd);
			temp.setDown(newNode);
		}
	}
	public CardNumberNode search2(int columnNumber,int columnIndex) {
		ColumnNode temp=head;
		int count=0;
		while(count<columnNumber) {
			temp=temp.getDown();
			count++;
		}
		count=0;
		CardNumberNode output;
		CardNumberNode temp2=temp.getRight();
		if (columnIndex == 0) {
			output = temp.getRight();
			temp.setRight(null);
			return output;
		}
		else {
			while(count<columnIndex-1) {
				temp2=temp2.getNext();
				count++;
			}
			output = temp2.getNext();
			temp2.setNext(null);
			return output;
		}
	}
	
	//add a number to the end of a column
	public void addCard(String column, int cardNumber) {
		if (head == null) {
			System.out.println("!! ERROR !! Add column !!");
		}
		else {
			ColumnNode temp = head;
			while (temp != null) {
				if (column.equalsIgnoreCase(temp.getColumnNumber())) {
					CardNumberNode temp2 = temp.getRight();
					if (temp2 == null) {
						CardNumberNode newNode = new CardNumberNode(cardNumber);
						temp.setRight(newNode);
					}
					else {
						while (temp2.getNext() != null) {
							temp2 = temp2.getNext();
						}
						CardNumberNode newNode = new CardNumberNode(cardNumber);
						temp2.setNext(newNode);
					}
				}
				temp = temp.getDown();
			}
		}
	}
	public int nodeCounter(CardNumberNode temp) {
		int count=0;
		while(temp!=null) {
			temp=temp.getNext();
			count++;
		}
		return(count);
	}
	public int lastData(int columnNumber,int columnIndex) {
		ColumnNode temp=head;
		int count=0;
		while(count<columnNumber) {
			temp=temp.getDown();
			count++;
		}
		count=0;
		CardNumberNode temp2=temp.getRight();
		if (columnIndex == 0) {
			return 0;
		}
		else {
			while(count<columnIndex-1) {
				temp2=temp2.getNext();
				count++;
			}
			return temp2.getCardNumber();
		}
	}
	public CardNumberNode takeData(int columnNumber,int columnIndex) {
		ColumnNode temp=head;
		int count=0;
		while(count<columnNumber) {
			temp=temp.getDown();
			count++;
		}
		count=0;
		CardNumberNode temp2=temp.getRight();
			while(count<columnIndex-1) {
				temp2=temp2.getNext();
				count++;
			}
			return temp2;
	}
	//count all columns
	public int columnCount() {
		int count = 0;
		if (head == null) {
			System.out.println("Linked list is empty");
		}
		else {
			ColumnNode temp = head;
			while (temp != null) {
				count++;
				temp = temp.getDown();
			}
		}
		return count;
	}
	
	public int columnSize(int index) {
		int count = 0;
		if (head == null) {
			System.out.println("Linked list is empty");
		}
		else {
			//move to the desired column
			ColumnNode temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.getDown();
			}
			CardNumberNode selectedColumn = temp.getRight();
			
			//count each element
			if (selectedColumn != null) {
				while (selectedColumn != null) {
					count++;
					selectedColumn = selectedColumn.getNext();
				}
			}
		}
		return count;
	}
	
	public void display() {
		if (head == null) {
			System.out.println("List is empty!!");
		}
		else {
			Columns.setForegroundColor(0.91, 0.91, 0.83);
			ColumnNode temp = head;
			int xAxis = 12 , yAxis = 6; // to print column by column
			while (temp != null) {
				console.getTextWindow().setCursorPosition(xAxis, yAxis);
				System.out.println();
				yAxis++;
				CardNumberNode temp2 = temp.getRight();
				while (temp2 != null) {
					// last card printing
					if (temp2.getNext() == null) {
						// if the number is 2 digit number
						if (temp2.getCardNumber() != 10) {
							// card drawing
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis);System.out.println(".------.\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 1);System.out.println("|"+temp2.getCardNumber() +".--. |\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 2);System.out.println("| :/\\: |\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 3);System.out.println("| (__) |\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 4);System.out.println("| '--'"+temp2.getCardNumber() +"|\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 5);System.out.println("`------'");
						}
						else {
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis);System.out.println(".------.\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 1);System.out.println("|"+temp2.getCardNumber() +".-. |\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 2);System.out.println("| :/\\: |\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 3);System.out.println("| (__) |\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 4);System.out.println("| '-'"+temp2.getCardNumber() +"|\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 5);System.out.println("`------'");
						}
						
					}
					else {
						if (temp2.getCardNumber() != 10) {
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis);System.out.println(".------.\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 1);System.out.println("|"+temp2.getCardNumber() +".--. |\r");
						}
						else {
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis);System.out.println(".------.\r");
							console.getTextWindow().setCursorPosition(xAxis - 3, yAxis + 1);System.out.println("|"+temp2.getCardNumber() +".-. |\r");
						}
					}
					
					temp2 = temp2.getNext();
					yAxis+= 2;
				}
				temp = temp.getDown();
				
				xAxis += 25;yAxis = 6;
				System.out.println();
			}
		}
		Columns.setForegroundColor(0.5, 0.5, 0.5);
	}
	
	public void clearDisplay() {
		if (head == null) {
			System.out.println("List is empty!!");
		}
		else {
			for (int x = 0 ; x <= 120; x++) {
				for (int y = 6; y < 49; y++) {
					console.getTextWindow().setCursorPosition(x, y);
					System.out.print("  ");
				}
			}
		}
		// clear box after using
		console.getTextWindow().setCursorPosition(132, 2);
		System.out.println(".------.\r");
		console.getTextWindow().setCursorPosition(132, 3);
		System.out.println("| .--. |\r");
		console.getTextWindow().setCursorPosition(132, 4);
		System.out.println("| :/\\: |\r");
		console.getTextWindow().setCursorPosition(132, 5);
		System.out.println("| '--' |\r");
		console.getTextWindow().setCursorPosition(132, 6);
		System.out.println("`------'\r");
	}
	
	public void findSet(int index) {
		if (head == null) {
			System.out.println("List is empty!!");
		}
		else {
			if (columnSize(index)>9) {
				ColumnNode temp = head;
				for (int i = 0; i < index; i++) {
					temp = temp.getDown();
				}
				CardNumberNode selectedColumn = temp.getRight();
				
				if (selectedColumn.getCardNumber() == 10) {
					CardNumberNode temp2 = selectedColumn.getNext();
					int counter = 9;
					while (temp2 != null) {
						if (temp2.getCardNumber() != counter) {
							break;
						}
						if ((temp2.getCardNumber() == counter)&&(counter == 1)) {
							temp.setRight(temp2.getNext());
							Columns.finishedOrderSets++; // increase the finished order sets count
							Columns.playerScore += 1000; // increase the player score for the pattern
							return;
						}
						temp2 = temp2.getNext();
						counter--;
					}
				}
				else if (selectedColumn.getCardNumber() == 1) {
					CardNumberNode temp2 = selectedColumn.getNext();
					int counter = 2;
					while (temp2 != null) {
						if (temp2.getCardNumber() != counter) {
							break;
						}
						if ((temp2.getCardNumber() == counter)&&(counter == 10)) {
							temp.setRight(temp2.getNext());
							Columns.finishedOrderSets++; // increase the finished order sets count
							Columns.playerScore += 1000; // increase the player score for the pattern
							return;
						}
						temp2 = temp2.getNext();
						counter++;
					}
				}
				for (int i = 0; i <= columnSize(index) - 11; i++) {
					if (selectedColumn.getNext().getCardNumber() == 10) {
						CardNumberNode temp2 = selectedColumn.getNext().getNext();
						int counter = 9;
						while (temp2 != null) {
							if (temp2.getCardNumber() != counter) {
								break;
							}
							if ((temp2.getCardNumber() == counter)&&(counter == 1)) {
								selectedColumn.setNext(temp2.getNext());
								Columns.finishedOrderSets++; // increase the finished order sets count
								Columns.playerScore += 1000; // increase the player score for the pattern
								return;
							}
							temp2 = temp2.getNext();
							counter--;
						}
					}
					else if (selectedColumn.getNext().getCardNumber() == 1) {
						CardNumberNode temp2 = selectedColumn.getNext().getNext();
						int counter = 2;
						while (temp2 != null) {
							if (temp2.getCardNumber() != counter) {
								break;
							}
							if ((temp2.getCardNumber() == counter)&&(counter == 10)) {
								selectedColumn.setNext(temp2.getNext());
								Columns.finishedOrderSets++; // increase the finished order sets count
								Columns.playerScore += 1000; // increase the player score for the pattern
								return;
							}
							temp2 = temp2.getNext();
							counter++;
						}
					}
					selectedColumn = selectedColumn.getNext();
				}
			}
		}
	}
}
