package org.generation.ensino.controller;

    import java.util.List;

    import org.generation.ensino.Model.Usuario;
    import org.generation.ensino.repository.UsuarioRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.CrossOrigin;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    
    @RestController
    @RequestMapping("/usuario")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public class UsuarioController {
        
        @Autowired
        private UsuarioRepository usuRepository;
        
        
        @GetMapping
        public ResponseEntity<List<Usuario>> getAll(){
            return ResponseEntity.ok(usuRepository.findAll());
        }
        
        
        @GetMapping("/{id}")
        public ResponseEntity<Usuario> GetById(@PathVariable long id){
            return usuRepository.findById(id)
                    .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
        }
        
        
        @GetMapping("/email/{email}")
        public ResponseEntity<List<Usuario>> GetByEmail(@PathVariable String email){
            return ResponseEntity.ok(usuRepository.findAllByEmailContainingIgnoreCase(email));
        }
        
       
        @PostMapping
        public ResponseEntity<Usuario> postUsuario (@RequestBody Usuario usuario){
            return ResponseEntity.status(HttpStatus.CREATED).body(usuRepository.save(usuario));
        }
        
        
         @PutMapping
         public ResponseEntity<Usuario> putUsuario (@RequestBody Usuario usuario){
            return ResponseEntity.ok(usuRepository.save(usuario));
         }
         
         
         @DeleteMapping("/{id}")
            public ResponseEntity<?> deleteRepository(@PathVariable long id) {
                return usuRepository.findById(id).map(resposta -> {
                    usuRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                }).orElse(ResponseEntity.notFound().build());
            }





}
