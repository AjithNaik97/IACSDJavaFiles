package com.fruitbasket;

public abstract class Fruit {
		protected String color;
		protected double weight;
		protected String name;
		protected boolean fresh=false;
		
		public Fruit()
		{
			color="NA";
			weight=0.0;
			name="Nil";
			fresh=false;
		}
		
		public Fruit(String name,String color,double weight)
		{
			this.color=color;
			this.weight=weight;
			this.name=name;
			fresh=true;
		}
		
		public String toString()
		{
			if(fresh)
				return "Name-"+name+" Color-"+color+" Weight-"+weight+"\nFruit is Fresh!";
			else
				return "Name-"+name+" Color-"+color+" Weight-"+weight+"\nFruit is Stale";
		}
		
		public abstract String taste();

		public void setFresh(boolean fresh) {
			this.fresh = fresh;
		}
		
		
}
