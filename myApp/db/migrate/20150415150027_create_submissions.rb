class CreateSubmissions < ActiveRecord::Migration
  def change
    create_table :submissions do |t|
      t.integer :iden
      t.boolean :deleted
      t.integer :type
      t.string :by
      t.integer :time
      t.text :text
      t.boolean :dead
      t.integer :parent
      t.integer :kids
      t.string :url
      t.integer :score
      t.string :title
      t.integer :descendants

      t.timestamps null: false
    end
  end
end
