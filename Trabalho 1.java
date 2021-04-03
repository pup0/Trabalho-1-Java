import java.util.Random;

class User {
  private String Name;
  private String Pass;
  private String Email;

  public User(String name, String pass, String email) {
    Name = name;
    Pass = pass;
    Email = email;
  }

  public String getName(){
    return Name;
  }

  public void setName(String name){
    Name = name;
  }

  public String getPass(){
    return Pass;
  }

  public void setPass(String pass){
    Pass = pass;
  }

  public String getEmail(){
    return Email;
  }

  public void setEmail(String email){
    Email = email;
  }
}



class Conta {
  private int IdConta;
  private float Saldo;
  private User User;

  public Conta(int idConta, float saldo, User user){
    IdConta = idConta;
    Saldo = saldo;
    User = user;
  }

  public int getIdConta(){
    return IdConta;
  }

  public void setIdConta(int idConta){
    IdConta = idConta;
  }

  public float getSaldo(){
    return Saldo;
  }

  public void setSaldo(float saldo){
    Saldo = saldo;
  }

  public User getUser(){
    return User;
  }
}


class Transacao {
  public String getTransacaoString(int id, String name, float valor){
    Random r = new Random();
    int random = r.nextInt((9999 - 1000) + 1) + 1000;

    return id + ";" + name + ";" + valor + ";" + random;
  }

  public String realizarTransferencia(Conta pagador, Conta recebedor, String Ts){
    String[] dados = Ts.split(";"); 
    
    if(recebedor.getIdConta() != Integer.parseInt(dados[0]))
      return "ID da conta incorreta";

    System.out.println(recebedor.getUser().getName()); 
    System.out.println(dados[1]); 
    if(recebedor.getUser().getName() == dados[1])
      return "Nome do recebedor incorreto";

    if(pagador.getSaldo() < Float.parseFloat(dados[2]))
      return "Saldo insuficiente";

    pagador.setSaldo(pagador.getSaldo() - Float.parseFloat(dados[2]));
    recebedor.setSaldo(recebedor.getSaldo() + Float.parseFloat(dados[2]));

    return "Transferencia realizada com sucesso!";
  }
}


class Main {  
  public static void main(String args[]) { 
    User u1 = new User("Fabio", "123", "email@ermail");
    User u2 = new User("Bruno", "123", "email@ermail");

    Conta acc1 = new Conta(1, 2000, u1);
    Conta acc2 = new Conta(2, 2000, u2);

    Transacao t = new Transacao();

    String st = t.getTransacaoString(1, "Fabio", 60);
    System.out.println(st); 
    String trans = t.realizarTransferencia(acc2, acc1, st);
    
    System.out.println(trans); 
    System.out.println(acc1.getSaldo()); 
    System.out.println(acc2.getSaldo()); 
  } 
}