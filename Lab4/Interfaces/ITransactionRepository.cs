namespace Lab7.Interfaces;

public interface ITransactionRepository
{
    ITransaction BeginTransaction();
}
