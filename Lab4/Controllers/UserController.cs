using Microsoft.AspNetCore.Mvc;

namespace Lab7.Controllers;

[ApiController]
[Route("api/v1/[controller]")]
public class UsersController : ControllerBase
{
    private readonly IUserRepository _repository;

    public UsersController(IUserRepository repository)
    {
        _repository = repository;
    }

    [HttpGet]
    public async Task<IActionResult> GetAll()
    {
        IEnumerable<User> users = await _repository.ReadAll();
        return Ok(users);
    }

    [HttpGet("{id}")]
    public async Task<IActionResult> GetById(Guid id)
    {
        User user = await _repository.Read(id);
        return Ok(user);
    }

    [HttpPost]
    public async Task<IActionResult> Create([FromBody] User user)
    {
        User createdUser = await _repository.Create(user);
        return Ok(createdUser);
    }

    [HttpPut("{id}")]
    public async Task<IActionResult> Update(Guid id, [FromBody] User user)
    {
        if (ModelState.IsValid)
        {
            await _repository.Update(id, user);
            return Ok();
        }
        return BadRequest();
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> DeleteById(Guid id)
    {
        await _repository.Delete(id);
        return Ok();
    }
}
