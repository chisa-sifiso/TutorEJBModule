
<body>

  <h1>Tutor Management System</h1>
  <p>Welcome to the Tutor Management System. This Java EE web application allows you to manage information about tutors, including their names, ages, gender, and the subjects they teach. The application uses JPA (Java Persistence API) to persist data into a database, ensuring a smooth and reliable data management process.</p>

  <h2>Overview</h2>
  <p>This application provides CRUD (Create, Read, Update, Delete) operations for managing tutor information. It stores tutor details such as their photo, age, subjects, and gender in a relational database. The data is persisted using JPA, which abstracts the underlying database interactions, making it easier to manage and maintain the application.</p>

  <h2>Project Structure</h2>
  <div class="file-structure">
      <ul>
          <li><b>Source Packages/</b></li>
          <ul>
              <li><b>za.ac.tut.bl</b></li>
              <ul>
                  <li><b>AbstractFacade.java</b> - This class is a generic abstract class providing basic CRUD operations for the entity classes using JPA.</li>
                  <li><b>TutorFacade.java</b> - Contains the business logic specific to the Tutor entity, such as calculating averages and retrieving the youngest tutor.</li>
                  <li><b>TutorFacadeLocal.java</b> - A local interface for the business logic, allowing access to the Tutor entity from other parts of the application.</li>
              </ul>
              <li><b>za.ac.tut.models</b></li>
              <ul>
                  <li><b>Tutor.java</b> - The entity class representing a tutor. It contains fields such as name, age, gender, subjects taught, and the photo of the tutor. This class is mapped to the database using JPA annotations.</li>
              </ul>
          </ul>
      </ul>
  </div>

  <h2>Database and JPA Configuration</h2>
  <p>The application uses JPA to persist data into the database. The entity class <code>Tutor</code> is mapped to a table in the database. Here’s how the mapping and persistence work:</p>

  <h3>Entity Class</h3>
  <p>The <code>Tutor</code> entity class is annotated with JPA annotations to map it to the corresponding table in the database:</p>
  <pre>
@Entity
public class Tutor implements Serializable {
    
  @Id
  private Long id;
  
  @Lob
  private byte[] photo;
  
  private String name;
  
  private Integer age;
  
  private String gender;
  
  @ElementCollection
  private List<String> subs;
  
  @Temporal(TemporalType.DATE)
  private Date date;

  // Getters, Setters, Constructors, and other methods
}
    </pre>
    <p>Each field in the <code>Tutor</code> class is mapped to a corresponding column in the database. For instance, the <code>@Lob</code> annotation specifies that the <code>photo</code> field is stored as a large binary object (BLOB), while <code>@Temporal</code> is used for the date field to specify the temporal type in the database.</p>

  <h3>Persistence Context</h3>
  <p>The <code>TutorFacade</code> class is responsible for managing CRUD operations through JPA. The class uses the <code>@PersistenceContext</code> annotation to inject the EntityManager that interacts with the database:</p>
  <pre>
@Stateless
public class TutorFacade extends AbstractFacade<Tutor> {

  @PersistenceContext(unitName = "TutorEJBModulePU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
      return em;
  }

  public TutorFacade() {
      super(Tutor.class);
  }
  
  // Additional methods for business logic
}
    </pre>
    <p>The <code>EntityManager</code> is used for performing database operations like persisting a tutor object, retrieving data, and executing queries. The <code>create()</code>, <code>edit()</code>, <code>remove()</code>, and <code>find()</code> methods of <code>AbstractFacade</code> are inherited and used to manage entities.</p>

  <h3>Example: Persisting a Tutor Object</h3>
  <p>To persist a tutor into the database, the application uses the <code>create()</code> method of the <code>TutorFacade</code>. Here’s an example of how a tutor is persisted:</p>
  <pre>
Tutor tutor = new Tutor();
tutor.setName("John Doe");
tutor.setAge(30);
tutor.setGender("M");
tutor.setPhoto(photoBytes); // Byte array of the tutor's photo

// Persisting the tutor into the database
tutorFacade.create(tutor);
    </pre>
    <p>This process saves the tutor object into the database, and it can be retrieved, updated, or deleted later using similar methods.</p>

  <h2>How to Use</h2>
  <p>After setting up the project and configuring the database, you can perform the following actions:</p>
  <ul>
      <li><b>Add Tutor:</b> Use a form to add tutor details (name, age, gender, photo, subjects) and persist it in the database.</li>
      <li><b>View Tutors:</b> Fetch all the tutor records from the database and display them on the web page.</li>
      <li><b>Delete Tutor:</b> Remove a tutor from the database by their ID.</li>
      <li><b>Get Stats:</b> Retrieve statistics such as the average age of male or female tutors, and the youngest tutor in the database.</li>
  </ul>

  <h2>Credits</h2>
  <p>This project was developed by [Your Name] as part of a Java EE and JPA learning module.</p>

</body>
</html>
