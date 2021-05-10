describe('neuspešna registracija', function () {
    it('Obisk strani za registracijo in neizpoljneni vsi inputi', function () {
        cy.visit('http://localhost:4200/signup')

        cy.url()
            .should('include', '/signup')

        cy.get('.name')
            .type('Metka')
            .should('have.value', 'Metka')

        cy.get('.username')
            .type('metkanovak')
            .should('have.value', 'metkanovak')

        cy.get('.email')
            .type('metkanovak@gmail.com')
            .should('have.value', 'metkanovak@gmail.com')

        cy.get('.password1')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('.password2')
            .type('metkametka')
            .should('have.value', 'metkametka')

        cy.get('[type="radio"]').check('lastnik')

        cy.get('.btn-primary')
            .click()
        cy.wait(500)

        cy.contains('Vsa polja morajo biti izpolnjena')
    });
});
