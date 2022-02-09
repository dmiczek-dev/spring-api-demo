package pl.dawidmiczek.apidemo.api;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogApi {

    private List<Dog> dogs;

    public DogApi() {
        this.dogs = new ArrayList<>();
        dogs.add(new Dog("Floki", "Shiba"));
        dogs.add(new Dog("Golden", "Golden Retriver"));
        dogs.add(new Dog("Doggo", "West Terrier"));
    }

    //Api request with header required
    @GetMapping
    public List<Dog> getDogs(@RequestHeader int amount) {
        return dogs.subList(0, amount);
    }
    //Add new dog to list
    @PostMapping
    public void addDog(@RequestBody Dog dog) {
       dogs.add(dog);
    }


}
