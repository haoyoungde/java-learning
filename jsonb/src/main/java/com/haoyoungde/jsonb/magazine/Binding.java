package com.haoyoungde.jsonb.magazine;

public enum Binding {
    HARD_BACK{
        @Override
        public String toString() {
            return "Hard Back";
        }
    },
    SOFT_BACK{
        @Override
        public String toString() {
            return "Soft Back";
        }
    }
}
