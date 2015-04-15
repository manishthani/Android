json.array!(@submissions) do |submission|
  json.extract! submission, :id, :iden, :deleted, :type, :by, :time, :text, :dead, :parent, :kids, :url, :score, :title, :descendants
  json.url submission_url(submission, format: :json)
end
