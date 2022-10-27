using Microsoft.EntityFrameworkCore.Storage;

namespace Lab7.DataAccessLayer.Transaction;

public class Transaction : ITransaction
{
    private readonly IDbContextTransaction _transaction;
    public Transaction(IDbContextTransaction transaction)
    {
        _transaction = transaction;
    }

    public async Task Commit()
    {
        await _transaction.CommitAsync();
    }

    public async Task RollBack()
    {
        await _transaction.RollbackAsync();
    }

    public void Dispose()
    {
        GC.SuppressFinalize(this);
    }
}
