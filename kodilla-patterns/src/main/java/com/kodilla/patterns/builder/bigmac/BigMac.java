package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    private final Bun bun;
    private final byte burgers;
    private final List<Sauce> sauce = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    private BigMac(Bun bun, byte burgers, List<Sauce> sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce.addAll(sauce);
        this.ingredients.addAll(ingredients);
    }

    public static class BigMacBuilder {
        private Bun bun;
        private byte burgers;
        private List<Sauce> sauce = new ArrayList<>();
        private List<Ingredient> ingredients = new ArrayList<>();

        public BigMacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(byte burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(Sauce sauce) {
            this.sauce.add(sauce);
            return this;
        }

        public BigMacBuilder ingredients(Ingredient ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
