using System.ComponentModel.DataAnnotations;
namespace Lab7.DataAccess.Models;

public class Annotation
{
    [Key] public string Id { get; set; }
    [Required] public Guid BookId { get; set; }
    [Required] public string Text { get; set; }
}