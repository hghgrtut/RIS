namespace Lab7.Interfaces;

public interface ITransaction : IDisposable
{
    Task Commit();
    Task RollBack();
}
