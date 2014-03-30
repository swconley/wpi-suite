package edu.wpi.cs.wpisuitetng.modules.PlanningPoker.model;

import java.util.Date;
import java.util.HashMap;

import edu.wpi.cs.wpisuitetng.modules.AbstractModel;
import edu.wpi.cs.wpisuitetng.modules.core.models.User;

/**
 * This is the DB4O model/schema for a game of planning poker, which tracks user
 * estimates for one user story.
 *
 * @author atrose
 */
public class PlanningPokerSession extends AbstractModel {
	// A primary key given uniquely to each session.
	private int id;

	// User ID of the user who has moderator permissions over this session.
	//
	// TODO: This should be initialized implicitly by the constructor to the ID
	// of the user creating the session.
	private int session_moderator_id;

	// IDs of each user who is allowed to estimate for this planning poker
	// session - INCLUDING the moderator.
	//
	// TODO: This should be initialized implicitly by the constructor to all
	// IDs of users working on the given project.
	private int[] participating_user_ids;

	// ID of the user story which this planning poker session is estimating
	// requirements for.
	private int user_story_id;

	// The values each user is allowed to choose from for their estimate.
	private int[] estimate_options;

	// A mapping of user IDs to that user's estimation for this session. Entries
	// in this map should be in the form <User's ID, User's estimate>.
	private HashMap<Integer, Integer> user_estimation_map;

	// A time limit for this session - after which users will be unable to
	// modify their estimates. A null `time_limit_minutes` means the session
	// will run until the moderator ends it, or until everyone has responded.
	private int time_limit_minutes;

	// The date/time this session was created at.
	//
	// TODO: This should be initialized implicitly by the constructor to
	// "new Date()" - which defaults to the current date/time.
	private Date date_time_created;

	// Indicates whether this session is still open for users to create/modify
	// their estimates.
	private boolean is_active;

	// Statistics about a session once it is complete.
	private double mean;
	private int mode;
	private int median;
	private int max;
	private int min;

	// The 'official' estimate to record on the user story, based on the
	// moderator's disgression after this session has ended.
	private int official_estimate;

	// TODO
	// Change `is_active` to false, and generate statistics.
	// public void end_session(){};

	// TODO
	// Add the user/estimation pair to the existing map of estimates.
	// public void add_estimate(int user_id, int users_estimate){};

	// TODO
	// Send a notification email to each user.
	// private void send_email_notification(){};

	/**
	 * The primary constructor for a PlanningPokerSession.
	 */
	// public PlanningPokerSession() {
	// }

	/* Serializing */

	/**
	 * TODO: Right now this is a copy of the same method from the `User` model.
	 */
	public String toJSON() {
		// String json;
		//
		// Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new
		// UserSerializer()).create();
		//
		// json = gson.toJson(this, User.class);
		//
		// return json;
		return null;
	}

	/**
	 * TODO: Right now this is a copy of the same method from the `User` model.
	 */
	// public static User fromJSON(String json) {
	// // build the custom serializer/deserializer
	// Gson gson;
	// GsonBuilder builder = new GsonBuilder();
	// builder.registerTypeAdapter(User.class, new UserDeserializer());

	// gson = builder.create();

	// return gson.fromJson(json, User.class);
	// }

	/* Built-in overrides/overloads */

	/**
	 * Override of toString() to return a JSON string.
	 */
	public String toString() {
		return this.toJSON();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof User) {
			if (((PlanningPokerSession) other).id == this.id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean identify(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}