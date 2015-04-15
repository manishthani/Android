class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.integer :iden
      t.integer :delay
      t.integer :created
      t.integer :karma
      t.text :about

      t.timestamps null: false
    end
  end
end
