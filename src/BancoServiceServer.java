import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<>();
        contas.add(new Conta("1", 100.0));
        contas.add(new Conta("2", 200.0));
        contas.add(new Conta("3", 300.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return contas.stream().filter(c -> c.getNumero().equals(conta)).findFirst().get().getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void criarConta(String conta, double saldo) throws RemoteException {
        contas.add(new Conta(conta, saldo));
    }

}