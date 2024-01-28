package Models;

public class Book {
    private int Id;
    private static int nextId=1;
    public String Name;
    public String Author;
    public String Language;
    public int Price;
    public int Count;
    public int getId(){
        return Id;
    }
    public Book(String Name, String Author, String Language, int Price, int Count){
        Id=nextId++;
        this.Name=Name;
        this.Author=Author;
        this.Count=Count;
        this.Language=Language;
        this.Price=Price;
    }
    public void FullInfo(){
        System.out.println("Book characteristics:");
        System.out.println("Id: "+Id);
        System.out.println("Name: "+Name);
        System.out.println("Author: "+Author);
        System.out.println("Language: "+Language);
        System.out.println("Price: "+Price);
        System.out.println("Count: "+Count);
        System.out.println("\n");

    }

}
