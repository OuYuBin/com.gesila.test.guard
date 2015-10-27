/**
 */
package com.gesila.test.guard.model.testGuard;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.gesila.test.guard.model.testGuard.TestGuard#getModule <em>Module</em>}</li>
 * </ul>
 *
 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard()
 * @model
 * @generated
 */
public interface TestGuard extends EObject {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' containment reference list.
	 * The list contents are of type {@link com.gesila.test.guard.model.testGuard.TestGuardModule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' containment reference list.
	 * @see com.gesila.test.guard.model.testGuard.TestGuardPackage#getTestGuard_Module()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestGuardModule> getModule();

} // TestGuard
