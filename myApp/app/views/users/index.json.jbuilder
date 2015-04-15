json.array!(@users) do |user|
  json.extract! user, :id, :iden, :delay, :created, :karma, :about
  json.url user_url(user, format: :json)
end
