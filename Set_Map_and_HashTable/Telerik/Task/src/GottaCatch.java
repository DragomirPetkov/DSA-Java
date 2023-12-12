import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class GottaCatch {
    private static Map<String,Set<Pokemon>> pokemonMap = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            switch (tokens[0]) {
                case "add":
                    addPokemon(tokens);
                    break;
                case "find":
                    findPokemon(tokens[1]);
                    break;
                case "ranklist":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);
//                    ranksPokemon(start, end);
                    break;
            }
            line = reader.readLine();
        }
        System.out.println(sb.toString());
    }

//    private static void ranksPokemon(int start, int end) {
//
//        for (int i = start - 1; i < end ; i++) {
//            sb.append(i + 1 ).append(".").append(pokemonList.get(i).getName())
//                    .append("(").append(pokemonList.get(i).getPower()).append("); ");
//        }
//        sb.delete(sb.length() - 2, sb.length());
//        sb.append(System.lineSeparator());
//    }
//
    private static void findPokemon(String type) {
//       sb.append("Type %s: %s%s",type,pokemonMap.get(type)
//                .stream().limit(5)
//                .map(Pokemon::toString).collect(Collectors.joining(";")));

    }


    private static void addPokemon(String[] tokens) {
        String name = tokens[1];
        String type = tokens[2];
        int power = Integer.parseInt(tokens[3]);
        int position = Integer.parseInt(tokens[4]);

        Pokemon newPokemon = new Pokemon(name,type,power,position);

        pokemonMap.putIfAbsent(name,new HashSet<>());
        pokemonMap.get(name).add(newPokemon);
        //Todo ranka

        sb.append(String.format("Added pokemon %s to position %d%n",name,position));
    }

}

class Pokemon implements Comparable<Pokemon> {
    private String name;
    private String type;
    private int power;
    private int position;

    public Pokemon(String name, String type, int power, int position) {
        setName(name);
        setType(type);
        setPower(power);
        setPosition(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 1 && name.length() <= 20) {
            this.name = name;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.length() >= 1 && type.length() <= 10) {
            this.type = type;
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power >= 10 && power <= 50) {
            this.power = power;
        }
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;
        Pokemon pokemon = (Pokemon) o;
        return power == pokemon.power && Objects.equals(name, pokemon.name) && Objects.equals(type, pokemon.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, power, position);
    }

    @Override
    public int compareTo(Pokemon o) {
        return name.compareTo(o.name) > 0 ? 1 : name.compareTo(name) < 0 ? -1 : Integer.compare(o.power, power);
    }

    @Override
    public String toString() {
        return String.format("%s(%d)",this.getName(),this.getPower());
    }
}

