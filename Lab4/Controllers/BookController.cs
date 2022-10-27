using Lab7.Models;
using Microsoft.AspNetCore.Mvc;

namespace Lab7.Controllers;

[ApiController]
[Route("api/v1/[controller]")]
public class BooksController : ControllerBase
{
    private readonly IBookRepository _bookRepository;
    private readonly IAnnotationRepository _annotationRepository;

    public BooksController(IBookRepository bookRepository, IAnnotationRepository annotationRepository)
    {
        _annotationRepository = annotationRepository;
        _bookRepository = bookRepository;
    }

    [HttpGet]
    public async Task<IActionResult> GetAll()
    {
        IEnumerable<Book> books = await _bookRepository.ReadAll();
        IEnumerable<Annotation> annotations = await _annotationRepository.ReadAll();

        var response = books.Join(
            annotations,
            b => b.Id,
            a => a.BookId,
            (a, b) => a.Id.Equals(b.BookId));

        return Ok(response);
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetById(Guid id)
    {
        Book book = await _bookRepository.Read(id);
        Annotation annotation = await _annotationRepository.ReadByBookId(id);

        var response = new BookModel()
        {
            Title = book.Title,
            Description = book.Description,
            Annotation = annotation.Text
        };

        return Ok(response);
    }

    [HttpPost]
    public async Task<IActionResult> Create([FromBody] BookModel request)
    {
        var bookTransaction = _bookRepository.BeginTransaction();
        var annotationTransaction = _annotationRepository.BeginTransaction();

        try
        {
            var createdBook = await _bookRepository.Create(new Book
            {
                Title = request.Title,
                Description = request.Description
            });

            await _annotationRepository.Create(new Annotation
            {
                BookId = createdBook.Id,
                Text = request.Annotation
            });
        }
        catch
        {
            await bookTransaction.RollBack();
            await annotationTransaction.RollBack();

            return BadRequest();
        }

        await bookTransaction.Commit();
        await annotationTransaction.Commit();

        return Ok();
    }

    [HttpPut("{id}")]
    public async Task<IActionResult> Update(Guid id, [FromBody] Book book)
    {
        if (ModelState.IsValid)
        {
            await _bookRepository.Update(id, book);
            return Ok();
        }
        return BadRequest();
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteById(Guid id)
    {
        await _bookRepository.Delete(id);
        return Ok();
    }
}
