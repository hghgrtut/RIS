using System.ComponentModel.DataAnnotations;

namespace Lab7.Models;

public class BookModel
{
    [Required] public string Title { get; set; }
    [Required] public string Description { get; set; }
    [Required] public string Annotation { get; set; }
}