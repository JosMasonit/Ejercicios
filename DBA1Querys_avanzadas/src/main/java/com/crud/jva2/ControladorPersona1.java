package com.crud.jva2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class ControladorPersona1 {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaRepositorio personaRepo;

    @Autowired
    EntityManager em;

    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";

    @GetMapping("/get")
    public List<PersonaEntity> getData(@RequestParam(required=false, value="usuario") String usuario,
                                       @RequestParam(value="name",required=false) String name,
                                       @RequestParam(value="surname", required=false) String surname,
                                       @RequestParam(value="created_date", required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date created_date,
                                       @RequestParam(value="dateCondition", required=false) String dateCondition,
                                       @RequestParam(required=false) String orden)
    {
        HashMap<String, Object> data=new HashMap<>();

        if (usuario!=null)
            data.put("usuario",usuario);
        if (name!=null)
            data.put("name",name);
        if (surname!=null)
            data.put("surname",surname);
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        if (!dateCondition.equals(GREATER_THAN) && 	!dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition=GREATER_THAN;
        if (created_date!=null)
        {
            data.put("created_date",created_date);
            data.put("dateCondition",dateCondition);
        }
        if (orden!=null)
            data.put("orden",orden);
        else{
            data.put("orden","id_persona");
        }

        return personaRepo.getData(data);

    }
    @GetMapping("/getQuery")
    public List<PersonaEntity> getDataQuery(@RequestParam(required=false, value="usuario") String usuario,
                                            @RequestParam(value="name",required=false) String name,
                                            @RequestParam(value="surname", required=false) String surname,
                                            @RequestParam(value="created_date", required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date created_date,
                                            @RequestParam(value="dateCondition", required=false) String dateCondition,
                                            @RequestParam(required=false) String orden)
    {
        HashMap<String, Object> data=new HashMap<>();


        String sql="select p from PersonaEntity p where 5=5";

        if (usuario!=null)
            sql+=" and p.usuario = :usuario";
        if (name!=null)
            sql+=" and p.name = :name";

        if (surname!=null)
            sql+=" and p.surname = :surname";
        String cond;
        if (dateCondition==null)
            dateCondition=GREATER_THAN;
        switch (dateCondition)
        {
            case GREATER_THAN:
                cond=">";
                break;
            case LESS_THAN:
                cond="<";
                break;
            default:
                cond="=";
        }
        if (created_date!=null)
            sql+=" and p.created_date "+cond+" :created_date";
        //ordenar los campos:
        if (orden !=null){
            switch (orden){
                case "name":
                    sql+=" order by name";
                    break;
                case "usuario":
                    sql+=" order by usuario";
                    break;
                default:
                    sql+=" order by id_persona";
            }
        }

        TypedQuery<PersonaEntity> query= em.createQuery(sql,PersonaEntity.class);
        if (usuario!=null)
            query.setParameter("usuario", usuario);
        if (name!=null)
            query.setParameter("name", name);

        if (surname!=null)
            query.setParameter("surname", surname);
        if (created_date!=null)
            query.setParameter("created_date", created_date);
        return query.getResultList();

    }

   /* @GetMapping("/get")
    public List<PersonaOutputDTO> listarUsuarios(){
        return personaService.getAll();
    } */
    @GetMapping("/getID/{id}")
    public PersonaOutputDTO buscarID(@PathVariable int id) throws Exception {
        return personaService.findByID(id);
    }
    @GetMapping("/getUsuario/{usuario}")
    public List<PersonaOutputDTO> buscarUsuario(@PathVariable String usuario) throws Exception {
        return personaService.findByUsuario(usuario);
    }

    @PostMapping("/addPersona")
    public PersonaOutputDTO crearPersona(@RequestBody PersonaInputDTO persona) throws Exception {
        System.out.println("En el Controlador de POST");
        PersonaOutputDTO personaOutputDTO = personaService.addPersona(persona);
        return personaOutputDTO;
    }

    @PutMapping("/update/{id}")
    public PersonaOutputDTO actualizarPersona(@PathVariable int id, @RequestBody PersonaInputDTO personaIDTO) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.actualizar(id, personaIDTO);
        return personaOutputDTO;
    }

    @DeleteMapping("delete/{id}")
    public PersonaOutputDTO borrarByID(@PathVariable int id) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.borrarPersona(id);
        return personaOutputDTO;
    }



   // @Transactional(propagation = Propagation.NOT_SUPPORTED)

}
