require 'test_helper'

class SubmissionsControllerTest < ActionController::TestCase
  setup do
    @submission = submissions(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:submissions)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create submission" do
    assert_difference('Submission.count') do
      post :create, submission: { by: @submission.by, dead: @submission.dead, deleted: @submission.deleted, descendants: @submission.descendants, iden: @submission.iden, kids: @submission.kids, parent: @submission.parent, score: @submission.score, text: @submission.text, time: @submission.time, title: @submission.title, type: @submission.type, url: @submission.url }
    end

    assert_redirected_to submission_path(assigns(:submission))
  end

  test "should show submission" do
    get :show, id: @submission
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @submission
    assert_response :success
  end

  test "should update submission" do
    patch :update, id: @submission, submission: { by: @submission.by, dead: @submission.dead, deleted: @submission.deleted, descendants: @submission.descendants, iden: @submission.iden, kids: @submission.kids, parent: @submission.parent, score: @submission.score, text: @submission.text, time: @submission.time, title: @submission.title, type: @submission.type, url: @submission.url }
    assert_redirected_to submission_path(assigns(:submission))
  end

  test "should destroy submission" do
    assert_difference('Submission.count', -1) do
      delete :destroy, id: @submission
    end

    assert_redirected_to submissions_path
  end
end
